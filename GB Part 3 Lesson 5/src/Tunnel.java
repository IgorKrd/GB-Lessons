import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    Semaphore semaphore = new Semaphore(MainClass.semaforCondition); // устанавливаем ограничения по количеству объектов которым "достуаен" Tunnel

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);

                semaphore.acquire(); // занимаем место в счётчике семафора (уменьшаем количество объектов которым разрешён доступ к объекту Tunnel

                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);

                semaphore.release();  // освобожаем место в счётчике семафора для нового претендента на доступ к объекту Tunnel
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
