// şifreyi göster/gizle
const showToggle = document.getElementById('showToggle');
const password = document.getElementById('password');
const passwordConfirmation = document.getElementById('confirm_password');
const lock1 = document.getElementById('lock1');
const lock2 = document.getElementById('lock2');

showToggle.addEventListener('change', function() {
    const type = this.checked ? 'text' : 'password';
    const className = this.checked ? 'fa-solid fa-lock-open' : "fa-solid fa-lock";

    password.setAttribute('type', type);
    passwordConfirmation.setAttribute('type', type);
    lock1.setAttribute('class', className);
    lock2.setAttribute('class', className);
});

