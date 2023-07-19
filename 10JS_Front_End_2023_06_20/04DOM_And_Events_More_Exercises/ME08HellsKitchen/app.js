function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick() {
      let input = JSON.parse(document.querySelector('#inputs textarea').value);

      let restaurants = [];

      for (let line of input) {
         let [name, workersData] = line.split(' - ');

         let workers = workersData.split(', ').map(data => {
            let [workerName, salary] = data.split(' ');
            let worker = {
               name: workerName,
               salary: Number(salary)
            }

            return worker;
         });

         if (restaurants.filter(r => r.name === name).length > 0) {
            let indexOfExistingRestaurant = restaurants.findIndex(r => r.name === name);

            workers = workers.concat(restaurants[indexOfExistingRestaurant].workers);

            workers.sort((w1, w2) => w2.salary - w1.salary);

            let bestSalary = workers[0].salary;

            let averageSalary = workers.reduce((acc, curr) => acc + curr.salary, 0) / workers.length;

            restaurants[indexOfExistingRestaurant].workers = workers;
            restaurants[indexOfExistingRestaurant].bestSalary = bestSalary;
            restaurants[indexOfExistingRestaurant].averageSalary = averageSalary;

         } else {

            workers.sort((w1, w2) => w2.salary - w1.salary);

            let bestSalary = workers[0].salary;

            let averageSalary = workers.reduce((acc, curr) => acc + curr.salary, 0) / workers.length;

            let restaurant = {
               name: name,
               workers: workers,
               bestSalary: bestSalary,
               averageSalary: averageSalary
            }

            restaurants.push(restaurant);

         }
      }

      let sortedRestourants = restaurants.sort((r1, r2) => r2.averageSalary - r1.averageSalary);

      let bestRestaurant = sortedRestourants[0];

      document.querySelector('#bestRestaurant p').textContent =
         `Name: ${bestRestaurant.name} Average Salary: ${bestRestaurant.averageSalary.toFixed(2)} Best Salary: ${bestRestaurant.workers[0].salary.toFixed(2)}`;

      document.querySelector('#workers p').textContent = bestRestaurant.workers.map(w => `Name: ${w.name} With Salary: ${w.salary}`).join(' ');
   }
}