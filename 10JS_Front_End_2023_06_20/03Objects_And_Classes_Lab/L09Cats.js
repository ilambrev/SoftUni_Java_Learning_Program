function cats(inputArr) {

    let catsFamily = [];

    class Cat {

        constructor(name, age) {
            this.name = name;
            this.age = age;
        }

        meow() {
            console.log(`${this.name}, age ${this.age} says Meow`);
        }
    }

    for (let element of inputArr) {

        let [name, age] = element.split(' ');

        catsFamily.push(new Cat(name, age));

    }

    catsFamily.forEach(cat => cat.meow());

}

// cats(['Mellow 2', 'Tom 5']);
// cats(['Candy 1', 'Poppy 3', 'Nyx 2']);