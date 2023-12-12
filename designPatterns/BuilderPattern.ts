// builder pattern
class HotDog1 {
    constructor(
        public bun: string,
        public ketchup: boolean,
        public mustard: boolean,
        public kraut: boolean
    ) { }
}

new HotDog1('wheat', true, true, false);

// Builder pattern
class HotDog2 {
    constructor(
        public bun: string,
        public ketchup?: boolean,
        public mustard?: boolean,
        public kraut?: boolean
    ) {

    }

    addKetchup() {
        this.ketchup = true;
        return this;
    }

    addMustard() {
        this.mustard = true;
        return this;
    }

    addKraut() {
        this.kraut = true;
        return this;
    }
}

const myLunch = new HotDog2('gluten free');
myLunch
    .addKetchup()
    .addMustard();
    