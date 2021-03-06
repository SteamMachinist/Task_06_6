# Task_06_6

При некоторых заданных x (допустимые значения x – интервал (-R, R)), n и e, определяемых вводом, вычислить:

1) сумму n слагаемых заданного вида;

2) сумму тех слагаемых, которые по абсолютной величине больше e;

3) сумму тех слагаемых, которые по абсолютной величине больше e/10;

4) значение функции с помощью методов Math.


![task_06_6_1](https://user-images.githubusercontent.com/71034843/101364503-b2808280-38b3-11eb-9ac9-1cae9db7ee6d.png)


Хотя указано, что x не имеет ограничений (-∞;+∞), что математически абсолютно верно, тем не менее при x ⪆ 8 требуется много слагаемых для сближения ряда к значению функции или вычисления суммы с эпсилон, что невозможно в силу необходимости вычисления факторила, который при увевеличении n быстро выходит за пределы типа long.



Для менее экстремальных значений всё работает:

![task_06_6_2](https://user-images.githubusercontent.com/71034843/101367044-c083d280-38b6-11eb-834c-5c85cdb5f5b7.png)

