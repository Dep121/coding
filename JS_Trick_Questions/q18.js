var fullName = 'Deepak pandey';
var obj = {
    fullName: 'suraj singh',
    prop: {
        fullName: 'Aurelio de Rose',
        getFullName: function() {
            return this.fullName;
        }
    },
    getMyName: function() {
        return this.fullName;
    },
    getFirstName: () => {
        return this.fullName?.split(' ')[0];
    },
    getLastName: (function() {
        return this.fullName?.split(' ')[1];
    })()
}

console.log(obj.prop.getFullName());
console.log(obj.getFirstName());
console.log(obj.getMyName());
console.log(obj.getLastName);


/**
 * Aurelio de Rose
 * undefined
 * suraj singh
 * undefined
 */