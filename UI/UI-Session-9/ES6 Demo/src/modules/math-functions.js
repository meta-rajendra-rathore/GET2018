function sum(a,b) {
	if (b==undefined) {
		return function(b1) {
			return a + b1;
		}
	} else {
		return a + b;
	}
}

const product = (a, b) => {
    return a * b;
};

export {sum, product};
