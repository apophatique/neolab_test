### Что это?
Реализация вступительных испытаний для поступления на стажировку в компанию neolab.io

### Задания
## Тур 1


## Тур 2

# Задание 1:
У вас есть массив чисел. Ваша задача отсортировать нечетные числа по возрастанию, но четные числа должны остаться на своих местах. 
Ноль является четным числом, и вам не нужно его перемещать. 
Если у вас пустой массив, его вам и нужно вернуть. 

Например: 
sortArray([5, 3, 2, 8, 1, 4]) == [1, 3, 2, 8, 5, 4]


# Задание 2:
Вам нужно реализовать метод, который будет корректировать переданное ему время. Время передается в виде строки. 
Формат времени должен быть от «00:00:00» до «23:59:59». 

Примеры применения функции:
  «09:10:01» → «09:10:01»
  «11:70:10» → «12:10:10»
  «19:99:99» → «20:40:39»
  «24:01:01» → «00:01:01»

Если входная строка является пустой, нужно её же и вернуть. 
Если строка не соответствует времени – выбросить исключение.

# Задание 3:
Представьте, что Вы пишете клиент-серверное приложение. Вам на вход приходит строка длиной в 16 символов (поле 4 на 4), которая представляет собой шахматное поле. В данной строке возможны следующие символы: 
  ‘ ‘ обозначает пустую клетку;
  ‘K' обозначает черного короля;
  ‘Q’ обозначает белую королеву;
  ‘B’ обозначает белого слона;
  ‘N’ обозначает белого коня;
  ‘R’ обозначает белую ладью;
  ‘P’ обозначает белую пешку. 

Нужно написать функцию, принимающую на вход поле из 16 символов в виде строчки.
Метод должен возвращать True, если черный король находится под шахом, и False, если нет. 
