let queue = [];

let eventNames = [
  "greet",
  "country",
  "name",
]

let subscriberMapping = []

function registerSubscriber(eventName, fn) {
  subscriberMapping.push({eventName, subscriber: fn})
}

function deRegisterSubscriber(eventName, fn) {
  subscriberMapping.filter({})
}


function publisher(eventName, data) {
  eventNames.forEach(en => {
      let subscribers = subscriberMapping.filter(({eventName}) => eventName === en)
      subscribers.forEach(sub => sub.subscriber( eventName, data))
  })
}

function greetSub(eventName, data) {
  console.log(`eventName: ${eventName} ===> ${data}`)
}

registerSubscriber("greet", greetSub);

publisher("greet", "deepak");

JSON.stringify(greetSub.name);
