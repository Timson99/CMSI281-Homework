public class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        HighArray arr; // reference to array
        arr = new HighArray(maxSize); // create the array
       
       //Population of Array
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display(); // display items
        int searchKey = 35; // search for item
        
        
        //Search key Test
        if( arr.find(searchKey) ) {
            System.out.println("Found " + searchKey);
        }
        else {
            System.out.println("Can't Find " + searchKey);
            arr.delete(00); // delete 3 items
            arr.delete(55);
            arr.delete(99);
            arr.display(); // display items again
        }       
        
        //getMax() tests
        arr.display(); // display items
        System.out.println(arr.getMax());
        arr.insert(100);
        arr.insert(600);
        arr.insert(560);
        arr.insert(4000);
        arr.display();
        System.out.println("");
        System.out.println(arr.getMax() + (arr.getMax() == 4000 ? ": Correct": " : Incorrect"));
        arr.delete(4000);
        arr.display();
        System.out.println("");
        System.out.println(arr.getMax() + (arr.getMax() == 600 ? ": Correct": " : Incorrect"));
        arr.delete(600);
        arr.display();
        System.out.println("");
        System.out.println(arr.getMax() + (arr.getMax() == 560 ? ": Correct": " : Incorrect"));
        arr.delete(560);
        arr.display();
        System.out.println("");
        System.out.println(arr.getMax() + (arr.getMax() == 100 ? ": Correct": " : Incorrect"));
        arr.delete(100);
        arr.display();
        System.out.println("");
        System.out.println(arr.getMax() + (arr.getMax() == 88 ? ": Correct": " : Incorrect"));
        
        
        // noDups() tests
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.insert(88);
        arr.insert(33);
        arr.display();
        arr.noDups();
        arr.display();
        
        
        
    }
} // end class HighArrayApp
////////////////////////////////////////////////////////////////