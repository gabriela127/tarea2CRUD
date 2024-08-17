package EjemplosConcurrencia;

public class Principal {
	public static void main(String[] args) {
        // Ejemplo 1: Creación de hilos usando Thread
        Thread thread1 = new ThreadEjemplo1();
        thread1.start();

        // Ejemplo 2: Creación de hilos usando Runnable
        Runnable runnable2 = new RunnableEjemplo2();
        Thread thread2 = new Thread(runnable2);
        thread2.start();

        // Ejemplo 3: Creación de hilos usando Lambda
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hilo 3 (Lambda) - Iteración: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread3.start();

        // Ejemplo 4: Gestión de hilos - Sincronización
        Contador contador = new Contador();
        Thread t1 = new Thread(new SincronizacionEjemplo(contador));
        Thread t2 = new Thread(new SincronizacionEjemplo(contador));
        t1.start();
        t2.start();

        // Ejemplo 5: Gestión de hilos - wait() y notify()
        Comunicacion comunicacion = new Comunicacion();
        Thread productor = new Thread(new Productor(comunicacion));
        Thread consumidor = new Thread(new Consumidor(comunicacion));
        productor.start();
        consumidor.start();
    }
}

// Ejemplo 1: Creación de hilos usando Thread
class ThreadEjemplo1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hilo 1 - Iteración: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Ejemplo 2: Creación de hilos usando Runnable
class RunnableEjemplo2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hilo 2 (Runnable) - Iteración: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Ejemplo 4: Gestión de hilos - Sincronización
class Contador {
    private int count = 0;

    public synchronized void incrementar() {
        count++;
        System.out.println("Contador: " + count);
    }
}

class SincronizacionEjemplo implements Runnable {
    private Contador contador;

    public SincronizacionEjemplo(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            contador.incrementar();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Ejemplo 5: Gestión de hilos - wait() y notify()
class Comunicacion {
    private boolean producido = false;

    public synchronized void producir() throws InterruptedException {
        while (producido) {
            wait();
        }
        System.out.println("Produciendo...");
        producido = true;
        notify();
    }

    public synchronized void consumir() throws InterruptedException {
        while (!producido) {
            wait();
        }
        System.out.println("Consumiendo...");
        producido = false;
        notify();
    }
}

class Productor implements Runnable {
    private Comunicacion comunicacion;

    public Productor(Comunicacion comunicacion) {
        this.comunicacion = comunicacion;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                comunicacion.producir();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumidor implements Runnable {
    private Comunicacion comunicacion;

    public Consumidor(Comunicacion comunicacion) {
        this.comunicacion = comunicacion;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                comunicacion.consumir();
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

