// Получаем форму
var form = document.getElementById('my-form');

// Добавляем обработчик события submit на форму
form.addEventListener('submit', function(event) {
  event.preventDefault(); // Отменяем стандартное поведение формы

  // Получаем значения полей ввода login и password
  var login = document.getElementById('login').value;
  var password = document.getElementById('password').value;

  // Создаем объект XMLHttpRequest
  var xhr = new XMLHttpRequest();

  // Настраиваем запрос для отправки POST запроса на сервер
  xhr.open('POST', 'http://localhost:8080/login');

  // Устанавливаем заголовок Content-Type для того, чтобы сервер знал, что мы отправляем данные в формате JSON
  xhr.setRequestHeader('Content-Type', 'application/json');

  // Устанавливаем обработчик события, который вызовется при получении ответа от сервера
  xhr.onload = function() {
    if (xhr.status === 200) {
      // Получаем идентификатор пользователя из ответа
      var userId = JSON.parse(xhr.responseText).id;
      console.log('Идентификатор пользователя: ' + userId);
      console.log(JSON.parse(xhr.responseText))
    } else {
      console.log('Ошибка запроса');
    }
  };

  // Отправляем запрос с параметрами login и password в теле запроса
  xhr.send(JSON.stringify({email: login, password: password}));
});