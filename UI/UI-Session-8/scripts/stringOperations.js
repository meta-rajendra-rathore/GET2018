//function to repeat a string n number of times
String.prototype.repeatify = function (number) {
    var string = "";
    for (var i = 0; i < number; i++) {
        string = string + this;
    }
    return string;
}

//function to remove consecutive repeating characters in a string
function removeConsecutiveCharacters(inputString) {
    for (var i = 0; i < inputString.length - 2; i++) {
        var index = i;
        var stringToBeReplaced = inputString.charAt(index);
        //find substring containing consecutive repeating characters
        while (inputString.charAt(index) == inputString.charAt(index + 1)) {
            stringToBeReplaced += inputString.charAt(index);
            index++;
        }
        if (index > i) {
            //removes consecutive repeating character substring if exists
            inputString = inputString.replace(stringToBeReplaced, "");
            if(i==0){
                i--;
            }
            else{
                //if substring is not removed from start position of string then repeatation is checked from one position before from current position.
                i=i-2;
            }
        }
    }
    return inputString;
}

