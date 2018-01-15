public class ArrayList<E> {

private Object[] array;
public static final int DEFAULT_SIZE = 25;
private int size = 0;

public ArrayList(){
    this(DEFAULT_SIZE);
}

public ArrayList(int size){
    array = new Object[size];
}

public void add(E k){
    checkSize();
    array[size++] = k;
}

public E remove(int i){
    if(i>=size || i < 0 ){throw new RuntimeException("Invalid index");}
    E e = (E)array[i];
    array[i] = null;
    --size;
    compress();
    return e;
}

public E get(int i){
    if(i > size){throw new RuntimeException("Invalid index");}
    E e = (E) array[i];
    return e;
}

private void checkSize(){
    if(size < array.length){ return;}   
    resize();
}

public int getSize(){
    return this.size;
}

/*public void sort()
{
	for (int i = 0; i < this.getSize(); i++)
        {
            int index = i;
            for (int j = i + 1; j < this.getSize(); j++)
                if (<E> this.get(j) < <E> this.get(index))) 
                    index = j;
            E smaller = this.get(index);  
            this.get(index) = this.get(i);
            arr[i] = smallerNumber;
        }
        return arr;
}*/

private void resize(){
    Object[] obj = new Object[array.length*2];
    copy(array,obj);
    array = obj;
}

private void copy(Object[] src, Object[] dest){
    if(dest.length< src.length){throw new RuntimeException(src+ " cannot be copied into "+dest);}
    for(int i=0;i<src.length; i++){
        dest[i] = src[i];
    }
}

private void compress(){
    int skipCount =0;
    for(int i=0;i < size && i<array.length; i++){
        if(array[i]==null)
        {
            ++skipCount;                
        }
        array[i]=array[i+skipCount];
    }
}

public static void main(String[] args)
{
	ArrayList<Integer> A =  new ArrayList<Integer>();
	A.add(19);
	A.add(21);
	A.add(23);
	A.add(45);
	A.add(51);
	A.add(71);
	A.remove(2);
	A.remove(1);
	System.out.println(A.get(0)+" "+A.get(1)+" "+A.get(2)+" "+A.get(3));
}
}