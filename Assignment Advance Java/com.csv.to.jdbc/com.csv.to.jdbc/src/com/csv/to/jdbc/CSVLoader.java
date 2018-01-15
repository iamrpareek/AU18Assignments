package com.csv.to.jdbc;
//import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.*;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import com.csvreader.CsvReader;

public class CSVLoader 
{
	private Connection con;
	private char s;
	private static final String SQL_INSERT = "INSERT INTO ${table}(${keys}) VALUES(${values})";
	private static final String TABLE_REGEX = "\\$\\{table\\}";
	private static final String KEYS_REGEX = "\\$\\{keys\\}";
	private static final String VALUES_REGEX = "\\$\\{values\\}";
	
	public CSVLoader(Connection c)
	{
		this.con = c;
		this.s = ',';
	}
	
	public void loadCSV(String csvFile, String tableName, boolean truncateBeforeLoad) throws Exception 
	{
		CsvReader csvReader = null;
		if(null == this.con) 
		{
			throw new Exception("Not a valid connection.");
		}
		try {
			csvReader = new CsvReader(new FileReader(csvFile), this.s);
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error! "+ e.getMessage());
		}
		String[] headerRow = csvReader.readNext();
		if (null == headerRow) {
			throw new FileNotFoundException("No columns. "+"Check the format.");
		}
		String q = StringUtils.repeat("?,", headerRow.length);
		q = (String) q.subSequence(0, q.length() - 1);
		String query = SQL_INSERT.replaceFirst(TABLE_REGEX, tableName);
		query = query.replaceFirst(KEYS_REGEX, StringUtils.join(headerRow, ","));
		query = query.replaceFirst(VALUES_REGEX, q);
		System.out.println("Query: " + query);
		String[] nextLine;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = this.con;
			con.setAutoCommit(false);
			ps = con.prepareStatement(query);
			if(truncateBeforeLoad) {
				con.createStatement().execute("DELETE FROM " + tableName);
			}
			final int batchSize = 1000;
			int count = 0;
			Date date = null;
			while ((nextLine = csvReader.readNext()) != null) {
				if (null != nextLine) {
					int index = 1;
					for (String st : nextLine) 
					{
						date = DateUtil.convertToDate(st);
						if (null != date) {
							ps.setDate(index++, new java.sql.Date(date
									.getTime()));
						} else {
							ps.setString(index++, st);
						}
					}
					ps.addBatch();
				}
				if (++count % batchSize == 0) {
					ps.executeBatch();
				}
			}
			ps.executeBatch();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw new Exception("Error: "+ e.getMessage());
		} finally {
			if (null != ps)
				ps.close();
			if (null != con)
				con.close();
			csvReader.close();
		}
	}

	public char getSeprator() 
	{
		return s;
	}

	public void setSeprator(char separator) 
	{
		this.s = separator;
	}
}