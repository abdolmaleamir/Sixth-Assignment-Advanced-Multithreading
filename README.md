# Advanced Multithreading


## Introduction
In this assignment, we are given three problems focused on various areas of multithreaded programming.

Lets review some of the methods I ve tried to calculate pi (ofcourse upsides and downsides are included):



1. Geometry-based method (Archimedes' method): This method involves inscribing and circumscribing polygons around a circle and calculating the perimeters of these polygons. The more sides the polygons have, the closer the approximation of Pi becomes. However, this method becomes impractical for polygons with a large number of sides, as the calculations can become extremely complex.

2. Infinite series methods: There are several infinite series methods for calculating Pi, such as the Leibniz formula, the Gregory-Leibniz series, and the Euler series. These methods involve summing up an infinite series of terms to get an approximation of Pi. The downside is that these series converge very slowly, meaning you need to sum up a large number of terms to get an accurate approximation.

3. Monte Carlo method: This is a statistical method that involves generating random points in a square and counting how many of them fall within a circle inscribed in the square. The ratio of the number of points in the circle to the total number of points can be used to estimate Pi. However, this method is probabilistic, meaning the approximation can vary each time you run the method. Also, it might require a large number of random points to get a good approximation, which can be computationally expensive.

4. Spigot algorithms: These are methods that can generate each digit of Pi on demand, without the need to calculate all the preceding digits. However, these algorithms can be complex and may not be as efficient as other methods for calculating Pi to a specific number of decimal places.

5. Arithmetic-geometric mean method: This is a method that involves calculating the arithmetic and geometric means of two numbers, and then repeating the process with the newly calculated means. This method can be used to calculate Pi, but it can be slow to converge and requires a good initial estimate.

6. One popular formula for calculating Pi is the Bailey-Borwein-Plouffe (BBP) formula, which allows for the calculation of individual hexadecimal digits of Pi without the need to calculate all the preceding digits. The formula is:

π = 1/4 * (1 + (1/2)^3 * ∑ from n=0 to infinity [(4/8n + 1)^(-3) - (4/(8n + 4))^(-3)] )

The BBP formula is particularly useful for calculating specific digits of Pi, as it allows for the calculation of any hexadecimal digit at any position without the need to calculate all the preceding digits. However, the formula is not well-suited for calculating Pi to a high degree of precision, as it converges very slowly.


the way of implement (step by step) :

Steps:

1. Create a thread pool: Divide the calculation into smaller tasks that can be executed concurrently.
2. Calculate each term: For each term (up to 1000), calculate the contribution to the summation using the Leibniz formula.
  Calculate x as 0.0625 raised to the power of n.
  Calculate aSum using the formula for the nth term.
  Multiply x by aSum.
3.Add each term to the running total: Use a synchronized method to add each calculated term to a shared variable sigma.
4. Wait for all tasks to complete: Shut down the thread pool and wait for all tasks to finish.
5. Return the approximation of Pi: Return the value of sigma as a string, truncated to the desired number of floating-point digits.

By dividing the calculation into smaller tasks and executing them concurrently, the PiCalculator class can approximate the value of Pi more efficiently and accurately.



semaohore

5 threads (Operator class) try to access a shared resource concurrently.
A Semaphore with an initial count of 2 is used to control access to the resource.
Only 2 threads can access the resource at a time; others wait until one of the busy threads releases the semaphore.
Each thread prints its name and accesses the resource, then releases the semaphore to allow other threads to access the resource.







