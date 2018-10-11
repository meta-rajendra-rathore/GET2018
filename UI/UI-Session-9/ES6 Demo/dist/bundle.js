/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/*!********************!*\
  !*** ./src/app.js ***!
  \********************/
/*! no exports provided */
/*! all exports used */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("Object.defineProperty(__webpack_exports__, \"__esModule\", { value: true });\n/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__modules_greeting__ = __webpack_require__(/*! ./modules/greeting */ 1);\n/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__modules_math_functions__ = __webpack_require__(/*! ./modules/math-functions */ 2);\n\n\n\nconst resultGreeting = document.getElementById('resultGreeting');\nconst resultSum = document.getElementById('resultSum');\nconst resultProduct = document.getElementById('resultProduct');\nconst showSum = document.getElementById('sum');\nconst showMulti = document.getElementById('multiply');\n\nresultGreeting.textContent = Object(__WEBPACK_IMPORTED_MODULE_0__modules_greeting__[\"a\" /* sayHello */])('Nice to see you! 😂');\n\nresultSum.style.display = 'none';\nresultProduct.style.display = 'none';\n\nconst a = 3;\nconst b = 2;\n\nshowSum.addEventListener('click', function () {\n    resultSum.style.display = 'block';\n    resultSum.textContent = `The sum of ${a} and ${b} when sum(a,b) is called is ${Object(__WEBPACK_IMPORTED_MODULE_1__modules_math_functions__[\"b\" /* sum */])(a, b)}. ✨ and The sum of ${a} and ${b} when sum(a)(b) is called is ${Object(__WEBPACK_IMPORTED_MODULE_1__modules_math_functions__[\"b\" /* sum */])(a) (b)}. ✨` ;\n});\n\nshowMulti.addEventListener('click', function () {\n    resultProduct.style.display = 'block';\n    resultProduct.textContent = `The product of ${a} and ${b} is ${Object(__WEBPACK_IMPORTED_MODULE_1__modules_math_functions__[\"a\" /* product */])(a, b)}. 🚀`;\n});//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiMC5qcyIsInNvdXJjZXMiOlsid2VicGFjazovLy8uL3NyYy9hcHAuanM/N2FjOSJdLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQgeyBzYXlIZWxsbyB9IGZyb20gJy4vbW9kdWxlcy9ncmVldGluZyc7XG5pbXBvcnQgeyBzdW0sIHByb2R1Y3QgfSBmcm9tICcuL21vZHVsZXMvbWF0aC1mdW5jdGlvbnMnO1xuXG5jb25zdCByZXN1bHRHcmVldGluZyA9IGRvY3VtZW50LmdldEVsZW1lbnRCeUlkKCdyZXN1bHRHcmVldGluZycpO1xuY29uc3QgcmVzdWx0U3VtID0gZG9jdW1lbnQuZ2V0RWxlbWVudEJ5SWQoJ3Jlc3VsdFN1bScpO1xuY29uc3QgcmVzdWx0UHJvZHVjdCA9IGRvY3VtZW50LmdldEVsZW1lbnRCeUlkKCdyZXN1bHRQcm9kdWN0Jyk7XG5jb25zdCBzaG93U3VtID0gZG9jdW1lbnQuZ2V0RWxlbWVudEJ5SWQoJ3N1bScpO1xuY29uc3Qgc2hvd011bHRpID0gZG9jdW1lbnQuZ2V0RWxlbWVudEJ5SWQoJ211bHRpcGx5Jyk7XG5cbnJlc3VsdEdyZWV0aW5nLnRleHRDb250ZW50ID0gc2F5SGVsbG8oJ05pY2UgdG8gc2VlIHlvdSEg8J+YgicpO1xuXG5yZXN1bHRTdW0uc3R5bGUuZGlzcGxheSA9ICdub25lJztcbnJlc3VsdFByb2R1Y3Quc3R5bGUuZGlzcGxheSA9ICdub25lJztcblxuY29uc3QgYSA9IDM7XG5jb25zdCBiID0gMjtcblxuc2hvd1N1bS5hZGRFdmVudExpc3RlbmVyKCdjbGljaycsIGZ1bmN0aW9uICgpIHtcbiAgICByZXN1bHRTdW0uc3R5bGUuZGlzcGxheSA9ICdibG9jayc7XG4gICAgcmVzdWx0U3VtLnRleHRDb250ZW50ID0gYFRoZSBzdW0gb2YgJHthfSBhbmQgJHtifSB3aGVuIHN1bShhLGIpIGlzIGNhbGxlZCBpcyAke3N1bShhLCBiKX0uIOKcqCBhbmQgVGhlIHN1bSBvZiAke2F9IGFuZCAke2J9IHdoZW4gc3VtKGEpKGIpIGlzIGNhbGxlZCBpcyAke3N1bShhKSAoYil9LiDinKhgIDtcbn0pO1xuXG5zaG93TXVsdGkuYWRkRXZlbnRMaXN0ZW5lcignY2xpY2snLCBmdW5jdGlvbiAoKSB7XG4gICAgcmVzdWx0UHJvZHVjdC5zdHlsZS5kaXNwbGF5ID0gJ2Jsb2NrJztcbiAgICByZXN1bHRQcm9kdWN0LnRleHRDb250ZW50ID0gYFRoZSBwcm9kdWN0IG9mICR7YX0gYW5kICR7Yn0gaXMgJHtwcm9kdWN0KGEsIGIpfS4g8J+agGA7XG59KTtcblxuXG4vLy8vLy8vLy8vLy8vLy8vLy9cbi8vIFdFQlBBQ0sgRk9PVEVSXG4vLyAuL3NyYy9hcHAuanNcbi8vIG1vZHVsZSBpZCA9IDBcbi8vIG1vZHVsZSBjaHVua3MgPSAwIl0sIm1hcHBpbmdzIjoiQUFBQTtBQUFBO0FBQUE7QUFBQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBIiwic291cmNlUm9vdCI6IiJ9\n//# sourceURL=webpack-internal:///0\n");

/***/ }),
/* 1 */
/*!*********************************!*\
  !*** ./src/modules/greeting.js ***!
  \*********************************/
/*! exports provided: sayHello */
/*! exports used: sayHello */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"a\", function() { return sayHello; });\nconst sayHello = (greeting) => {\n    const currentHour = new Date().getHours();\n    let timeGreeting = 'Good morning!';\n\n    if (currentHour >= 12 && currentHour <= 17) {\n        timeGreeting = 'Good afternoon!';\n    } else if (currentHour >= 17) {\n        timeGreeting = 'Good evening!';\n    }\n\n    return `${timeGreeting} ${greeting}`;\n}\n\n\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiMS5qcyIsInNvdXJjZXMiOlsid2VicGFjazovLy8uL3NyYy9tb2R1bGVzL2dyZWV0aW5nLmpzP2RiOTUiXSwic291cmNlc0NvbnRlbnQiOlsiY29uc3Qgc2F5SGVsbG8gPSAoZ3JlZXRpbmcpID0+IHtcbiAgICBjb25zdCBjdXJyZW50SG91ciA9IG5ldyBEYXRlKCkuZ2V0SG91cnMoKTtcbiAgICBsZXQgdGltZUdyZWV0aW5nID0gJ0dvb2QgbW9ybmluZyEnO1xuXG4gICAgaWYgKGN1cnJlbnRIb3VyID49IDEyICYmIGN1cnJlbnRIb3VyIDw9IDE3KSB7XG4gICAgICAgIHRpbWVHcmVldGluZyA9ICdHb29kIGFmdGVybm9vbiEnO1xuICAgIH0gZWxzZSBpZiAoY3VycmVudEhvdXIgPj0gMTcpIHtcbiAgICAgICAgdGltZUdyZWV0aW5nID0gJ0dvb2QgZXZlbmluZyEnO1xuICAgIH1cblxuICAgIHJldHVybiBgJHt0aW1lR3JlZXRpbmd9ICR7Z3JlZXRpbmd9YDtcbn1cblxuZXhwb3J0IHtzYXlIZWxsb307XG5cblxuXG4vLy8vLy8vLy8vLy8vLy8vLy9cbi8vIFdFQlBBQ0sgRk9PVEVSXG4vLyAuL3NyYy9tb2R1bGVzL2dyZWV0aW5nLmpzXG4vLyBtb2R1bGUgaWQgPSAxXG4vLyBtb2R1bGUgY2h1bmtzID0gMCJdLCJtYXBwaW5ncyI6IkFBQUE7QUFBQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBOyIsInNvdXJjZVJvb3QiOiIifQ==\n//# sourceURL=webpack-internal:///1\n");

/***/ }),
/* 2 */
/*!***************************************!*\
  !*** ./src/modules/math-functions.js ***!
  \***************************************/
/*! exports provided: sum, product */
/*! exports used: product, sum */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"b\", function() { return sum; });\n/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, \"a\", function() { return product; });\nfunction sum(a,b) {\n\tif (b==undefined) {\n\t\treturn function(b1) {\n\t\t\treturn a + b1;\n\t\t}\n\t} else {\n\t\treturn a + b;\n\t}\n}\n\nconst product = (a, b) => {\n    return a * b;\n};\n\n\n//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiMi5qcyIsInNvdXJjZXMiOlsid2VicGFjazovLy8uL3NyYy9tb2R1bGVzL21hdGgtZnVuY3Rpb25zLmpzP2VlOTciXSwic291cmNlc0NvbnRlbnQiOlsiZnVuY3Rpb24gc3VtKGEsYikge1xuXHRpZiAoYj09dW5kZWZpbmVkKSB7XG5cdFx0cmV0dXJuIGZ1bmN0aW9uKGIxKSB7XG5cdFx0XHRyZXR1cm4gYSArIGIxO1xuXHRcdH1cblx0fSBlbHNlIHtcblx0XHRyZXR1cm4gYSArIGI7XG5cdH1cbn1cblxuY29uc3QgcHJvZHVjdCA9IChhLCBiKSA9PiB7XG4gICAgcmV0dXJuIGEgKiBiO1xufTtcblxuZXhwb3J0IHtzdW0sIHByb2R1Y3R9O1xuXG5cblxuLy8vLy8vLy8vLy8vLy8vLy8vXG4vLyBXRUJQQUNLIEZPT1RFUlxuLy8gLi9zcmMvbW9kdWxlcy9tYXRoLWZ1bmN0aW9ucy5qc1xuLy8gbW9kdWxlIGlkID0gMlxuLy8gbW9kdWxlIGNodW5rcyA9IDAiXSwibWFwcGluZ3MiOiJBQUFBO0FBQUE7QUFBQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7Iiwic291cmNlUm9vdCI6IiJ9\n//# sourceURL=webpack-internal:///2\n");

/***/ })
/******/ ]);