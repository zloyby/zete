package by.zloy.test;

/**
 * @author EugenKozlov
 */
public class TestWhileContinueBreak
{
    private volatile boolean active = true;

    public static void main(String[] args)
    {
        TestWhileContinueBreak t = new TestWhileContinueBreak();
        t.run();
    }

    private void run()
    {
        int i = 1;
        while (active)
        {
            if (i % 50 == 0)
            {
                active = false;
                System.out.println("Break");
                break;
            }

            if (i > 20 && i < 30)
            {
                i++;
                continue;
            }

            System.out.println(i);
            i++;
        }
    }
}
