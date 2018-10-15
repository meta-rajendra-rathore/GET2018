window.addEventListener('load', main);

//main function to test linked list, stack and queue implementation 
function main(event) {
    //singly linked list
    var singlyLinkedListObject = new singlyLinkedList();
    singlyLinkedListObject.add(10);
    singlyLinkedListObject.add(20);
    singlyLinkedListObject.add(30);
    singlyLinkedListObject.add(40);
    singlyLinkedListObject.add(50);
    singlyLinkedListObject.add(60);
    singlyLinkedListObject.add(70);
    singlyLinkedListObject.add(80);
    singlyLinkedListObject.add(90);
    singlyLinkedListObject.add(100);
    singlyLinkedListObject.printList();
    console.log(singlyLinkedListObject.remove(1));
    console.log(singlyLinkedListObject.remove(1));
    console.log(singlyLinkedListObject.remove(3));
    console.log(singlyLinkedListObject.remove(6));
    singlyLinkedListObject.printList();

    //doubly linked list
    var doublyLinkedListObject = new doublyLinkedList();
    doublyLinkedListObject.add(10);
    doublyLinkedListObject.add(20);
    doublyLinkedListObject.add(30);
    doublyLinkedListObject.add(40);
    doublyLinkedListObject.add(50);
    doublyLinkedListObject.add(60);
    doublyLinkedListObject.add(70);
    doublyLinkedListObject.add(80);
    doublyLinkedListObject.add(90);
    doublyLinkedListObject.printList();
    console.log(doublyLinkedListObject.remove(2));
    console.log(doublyLinkedListObject.remove(6));
    console.log(doublyLinkedListObject.remove(3));
    doublyLinkedListObject.printList();

    //remove consecutive repeating characters of a string
    console.log(removeConsecutiveCharacters("fabccccbagccfg"));

    //stack 
    var stackObject = new stack();
    stackObject.push(10);
    stackObject.push(20);
    stackObject.push(30);
    stackObject.push(40);
    console.log(stackObject);
    stackObject.pop();
    console.log(stackObject);

    //queue
    queueObject = new queue();
    queueObject.enqueue(10);
    queueObject.enqueue(20);
    queueObject.enqueue(30);
    queueObject.enqueue(40);
    console.log(queueObject);
    console.log(queueObject.dequeue());
    console.log(queueObject);

    //to repeat a string n number of times 
    console.log("hello".repeatify(3));
}
