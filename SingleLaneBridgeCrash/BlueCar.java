class BlueCar extends Thread
{
    private Bridge abridge;

    public BlueCar (Bridge b)
    {
        abridge = b;
        this.setName("Blue Car");
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