# JSchool Session-1

* Обязательные задачи:
	* Написать программу, которая выводит все аргументы, которые ей передали.
	* Написать программу, которая выводит все системные переменные.
	* Написать программу, которая выводит все переменные окружения.
	* Написать программу, которая выводит "Hello, World!" количество раз переданное:
		* Если передан параметр вида `JSCHOOl1_COUNT=XXX`, где `XXX` число раз, то используется оно.
		* Если передана системная настройка вида `JSCHOOl1_COUNT=XXX`, где `XXX` число раз, то используется оно.
		* Если определена переменная окружения вида `JSCHOOl1_COUNT=XXX`, где `XXX` число раз, то используется оно.
		* Если определена переменная окружения вида `JSCHOOL1_PROPERTIES_FILE=XXX`, где `XXX` это путь к существующему файлу, то загружаем настройки оттуда и пытаемся получить настройку оттуда.
		* Если ничего не задано, выводим сообщение о вариантах исопльзования программы и завершаем.
* Дополнительные задачи:
	* На вход подаётся строка, содержащее число в бинарной системе счичсления. Нужно вернуть десятичное число(long)
		`public long binaryToDec(String binary);`
	* На вход подаются 2 строки, содержащие двоичные числа - вернуть строку, содержащую сумму этих чисел в двоичной системе счисления.
		`public long sumOfBinary(String b1, String b2);`
	* На вход методу подаётся два массива long. Вернуть элементы, которые встречаются в обоих массивах
		`public long[] intersection(long[] arr1, long[] arr2);`
