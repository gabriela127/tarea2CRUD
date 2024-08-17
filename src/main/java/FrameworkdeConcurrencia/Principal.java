package FrameworkdeConcurrencia;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutionException;

public class Principal {
	public static void main(String[] args) {
        // Crear un ExecutorService con un pool de 3 hilos
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            // Ejemplo 1: Ejecutar una tarea que devuelve un resultado usando Callable
            Callable<Integer> task1 = () -> {
                Thread.sleep(1000);
                return 5 + 10;
            };
            Future<Integer> future1 = executor.submit(task1);
            System.out.println("Resultado del Task 1: " + future1.get());

            // Ejemplo 2: Ejecutar una tarea que no devuelve un resultado usando Runnable
            Runnable task2 = () -> {
                try {
                    Thread.sleep(500);
                    System.out.println("Task 2 completado");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            };
            Future<?> future2 = executor.submit(task2);
            future2.get(); // Esperar a que el task2 complete

            // Ejemplo 3: Ejecutar una tarea con resultado usando Callable y manejar excepciones
            Callable<String> task3 = () -> {
                Thread.sleep(2000);
                if (true) throw new RuntimeException("Error en Task 3");
                return "Tarea completada con éxito";
            };
            Future<String> future3 = executor.submit(task3);

            try {
                System.out.println("Resultado del Task 3: " + future3.get());
            } catch (ExecutionException e) {
                System.err.println("Excepción en Task 3: " + e.getCause().getMessage());
            }

            // Ejemplo 4: Ejecución de múltiples tareas concurrentemente usando ExecutorService
            for (int i = 0; i < 3; i++) {
                int taskId = i;
                executor.submit(() -> {
                    try {
                        Thread.sleep(1000 * (taskId + 1));
                        System.out.println("Tarea concurrente " + taskId + " completada");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }

            // Finalizar el ExecutorService
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println("Todas las tareas completadas.");

        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Excepción principal: " + e.getMessage());
        }
    }
}
