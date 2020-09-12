const APP_VIEW = document.getElementById('app-view');
const NAV_BAR_CONTAINER = document.getElementById('navbar-container');

let currentPartialInAppView;


window.onload = function() {

    loadLoggedOutFullHome();

}

//-------------------LOAD FULL HOMES------------------------

function loadLoggedOutFullHome(){
    loadLogin();
    loadLoggedOutNavbar();
}

function loadLoggedInFullHome(){
    loadHome();
    loadLoggedInNavbar();
}

//----------------------LOAD VIEWS-------------------------



function loadLoggedOutNavbar(){

    console.log('in loadLoggedOutNavbar()');

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'loadLoggedOutNavbar.view',true);
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            NAV_BAR_CONTAINER.innerHTML = xhr.responseText;
            configureLoggedOutNavbar();
        }
    }

}

function loadLoggedInNavbar(){

    console.log('in loadLoggedInnavbar()')

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'loadLoggedInNavbar.view', true);
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            NAV_BAR_CONTAINER.innerHTML = xhr.responseText;
            configureLoggedInNavbar();
        }
    }
}

function loadLogin() {

    console.log('in loadLogin()');

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'login.view', true); // third parameter (default true) indicates we want to make this req async


    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
            configureLoginView();
        }
    }

}

function loadRegister() {

    console.log('in loadRegister()');

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'register.view'); // third parameter of this method is optional (defaults to true)
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
            configureRegisterView();
        }
    }

}

function loadHome() {

    console.log('in loadHome()');

    if(!isUserLoggedIn()){
        return;
    }

    let xhr = new XMLHttpRequest();

    console.log(localStorage.getItem('authUser'));

    xhr.open('GET', 'home.view');
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
            configureHomeView();
        }
    }

}

function loadMyReimbursements() {

    console.log('in loadMyReimbursements()');

    if(!isUserLoggedIn()){
        return;
    }

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'myReimbursements.view');
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
            configureMyReimbursementsView();
        }
    }

}

function loadProfile() {

    console.log('in loadProfile()');

    if(!isUserLoggedIn()){
        return;
    }

    let xhr = new XMLHttpRequest();

    console.log(localStorage.getItem('authUser'));

    xhr.open('GET',  'profile.view');
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
            configureProfileView();
        }
    }

}

//----------------CONFIGURE VIEWS--------------------

function configureLoggedOutNavbar(){
    document.getElementById('toLogin').addEventListener('click', loadLogin);
    document.getElementById('toRegister').addEventListener('click', loadRegister);
}

function configureLoggedInNavbar(){
    document.getElementById('toHome').addEventListener('click', loadHome);
    document.getElementById('toProfile').addEventListener('click', loadProfile);
    document.getElementById('toLogout').addEventListener('click', logout);

}

function configureLoginView() {

    console.log('in configureLoginView()');

    document.getElementById('login-message').setAttribute('hidden', true);
    document.getElementById('login-button-container').addEventListener('mouseover', validateLoginForm);
    document.getElementById('login').addEventListener('click', login);

}

function configureRegisterView() {

    console.log('in configureRegisterView()');

    document.getElementById('reg-message').setAttribute('hidden', true);

    document.getElementById('reg-username').addEventListener('blur', isUsernameAvailable);
    document.getElementById('email').addEventListener('blur', isEmailAvailable);

    document.getElementById('register').setAttribute('disabled', true);
    document.getElementById('reg-button-container').addEventListener('mouseover', validateRegisterForm);
    document.getElementById('register').addEventListener('click', register);

}

function configureHomeView() {

    console.log('in configureHomeView()');
    let authUser = JSON.parse(localStorage.getItem('authUser'));


    document.getElementById('loggedInUsername').innerText = authUser.username;

}

function configureMyReimbursementsView() {

    console.log('in configureMyReimbursementsView()');

    //let authUser = JSON.parse(localStorage.getItem('authUser'));
    //document.getElementById('loggedInUsername').innerText = authUser.username;

}

function configureProfileView() {

    console.log('in configureProfileView()');

}



//------------------OPERATIONS-----------------------

function login() {

    console.log('in login()');

    let un = document.getElementById('login-username').value;
    let pw = document.getElementById('login-password').value;

    let credentials = {
        username: un,
        password: pw
    }

    let credentialsJSON = JSON.stringify(credentials);

    let xhr = new XMLHttpRequest();

    xhr.open('POST', 'auth');
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(credentialsJSON);

    xhr.onreadystatechange = function () {

        if (xhr.readyState == 4 && xhr.status == 200) {

            document.getElementById('login-message').setAttribute('hidden', true);
            localStorage.setItem('authUser', xhr.responseText);
            loadLoggedInFullHome();

        } else if (xhr.readyState == 4 && xhr.status == 401) {

            document.getElementById('login-message').removeAttribute('hidden');
            let err = JSON.parse(xhr.responseText);
            document.getElementById('login-message').innerText = err.message;

        }

    }

}

function register() {

    console.log('in register()');

    let fn = document.getElementById('fn').value;
    let ln = document.getElementById('ln').value;
    let email = document.getElementById('email').value;
    let un = document.getElementById('reg-username').value;
    let pw = document.getElementById('reg-password').value;

    let newUser = {
        firstName: fn,
        lastName: ln,
        email: email,
        username: un,
        password: pw
    }

    let newUserJSON = JSON.stringify(newUser);

    let xhr = new XMLHttpRequest();

    xhr.open('POST', 'users');
    xhr.send(newUserJSON);

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 201) {
            loadLogin();
        } else if (xhr.readyState == 4 && xhr.status != 201) {
            document.getElementById('reg-message').removeAttribute('hidden');
            let err = JSON.parse(xhr.responseText);
            document.getElementById('reg-message').innerText = err.message;
        }
    }


}

function logout() {

    console.log('in logout()');

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'auth');
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 204) {
            console.log('logout successful!');
            localStorage.removeItem('authUser');
            loadLoggedOutFullHome()
        }
    }
}

function isUsernameAvailable() {

    console.log('in isUsernameAvailable()');

    let username = document.getElementById('reg-username').value;

    if (!username) {
        return;
    }

    let xhr = new XMLHttpRequest();

    xhr.open('POST', 'username.validate');
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(JSON.stringify(username));

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 204) {
            console.log('Provided username is available!');
            document.getElementById('reg-message').setAttribute('hidden', true);
        } else if (xhr.readyState == 4 && xhr.status == 409 ) {
            document.getElementById('reg-message').removeAttribute('hidden')
            document.getElementById('reg-message').innerText = 'The provided username is already taken!';
            document.getElementById('register').setAttribute('disabled', true);
        }
    }

}

function isEmailAvailable() {

    console.log('in isEmailAvailable()');

    let email = document.getElementById('email').value;

    if (!email) {
        return;
    }

    let xhr = new XMLHttpRequest();

    xhr.open('POST', 'email.validate');
    xhr.setRequestHeader('Content-type', 'application/json');
    xhr.send(JSON.stringify(email));

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 204) {
            console.log('Provided email is available!');
            document.getElementById('reg-message').setAttribute('hidden', true);
        } else if (xhr.readyState == 4 && xhr.status == 409) {
            document.getElementById('reg-message').removeAttribute('hidden');
            document.getElementById('reg-message').innerText = 'The provided email address is already taken!';
            document.getElementById('register').setAttribute('disabled', true);
        }
    }
}

function getUserInfo() {

    console.log('in getUserInfo()');

    xhr.open('GET', 'userinfo.database');
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            return userInfo = JSON.parse(xhr.responceText);
        }

    }
}


function isUserLoggedIn(){
    if (!localStorage.getItem('authUser')) {
        console.log('No user logged in, navigating to login screen');
        loadLoggedOutFullHome()
        return false;
    }

    return true;
}


//---------------------FORM VALIDATION-------------------------

function validateLoginForm() {

    console.log('in validateLoginForm()');

    let msg = document.getElementById('login-message').innerText;

    if (msg == 'User authentication failed!') {
        return;
    }

    let un = document.getElementById('login-username').value;
    let pw = document.getElementById('login-password').value;

    if (!un || !pw) {
        document.getElementById('login-message').removeAttribute('hidden');
        document.getElementById('login-message').innerText = 'You must provide values for all fields in the form!';
        document.getElementById('login').setAttribute('disabled', true);
    } else {
        document.getElementById('login').removeAttribute('disabled');
        document.getElementById('login-message').setAttribute('hidden', true);
    }

}

function validateRegisterForm() {

    console.log('in validateRegisterForm()');

    let fn = document.getElementById('fn').value;
    let ln = document.getElementById('ln').value;
    let email = document.getElementById('email').value;
    let un = document.getElementById('reg-username').value;
    let pw = document.getElementById('reg-password').value;

    if (!fn || !ln || !email || !un || !pw) {
        document.getElementById('reg-message').removeAttribute('hidden');
        document.getElementById('reg-message').innerText = 'You must provided values for all fields in the form!'
        document.getElementById('register').setAttribute('disabled', true);
    } else {
        document.getElementById('register').removeAttribute('disabled');
        document.getElementById('reg-message').setAttribute('hidden', true);
    }
}