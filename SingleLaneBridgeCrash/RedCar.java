class RedCar extends Thread
{
    private Bridge abridge;

    public RedCar( Bridge b)
    {
        abridge = b;
        this.setName("Red Car");
    }

    
    public void run()
    {
                for(int i = 0; i<100; i++) {
                    abridge.arrive();
                    abridge.cross();
                    abridge.depart();

                }
    }
}