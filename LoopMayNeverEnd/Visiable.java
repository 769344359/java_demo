class Visible{
    public static  int counter = 0 ; 
    public static  void main(String[]  argc){
        Runnable runnable = () -> counter++ ;
        Runnable runnable2 = () -> {
            
            try{
                Thread.sleep(1000);
                System.out.print(counter);
            }catch(Exception exception){

            }
        }; 
        Thread t1 = new Thread(runnable); 
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();
    }

}