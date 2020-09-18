const APP_VIEW = document.getElementById('app-view');
const NAV_BAR_CONTAINER = document.getElementById('navbar-container');

let currentPartialInAppView;


window.onload = function() {

    loadLoggedOutFullHome();

}


//#region load-navbars

function loadLoggedOutNavbar() {

    console.log('in loadLoggedOutNavbar()');

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'loadLoggedOutNavbar.view', true);
    xhr.send();

    xhr.onreadystatechange = function () {
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

//#endregion

//#region load-logged-out-views

function loadLogin() {

    console.log('in loadLogin()');

    let xhr = new XMLHttpRequest();

    // third parameter (optional since it defaults to true) indicates we want to make this req async
    xhr.open('GET', 'login.view', true);


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

    xhr.open('GET', 'register.view');
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
            configureRegisterView();
        }
    }

}




//#endregion

//#region load-logged-in-for-all-views

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
//#endregion

//#region load-full-homes

function loadLoggedOutFullHome(){
    loadLogin();
    loadLoggedOutNavbar();
}

function loadLoggedInFullHome(){

    loadLoggedInNavbar();

    let authUser = JSON.parse(localStorage.getItem('authUser'));;

    console.log(authUser.username);
    
    console.log("authuser role: " + authUser.roleName);

    if(authUser.roleName=='Admin'){
        console.log('user is admin!');
        loadAdminHomeView();

    } else if(authUser.roleName=='Employee'){
        console.log('user is employee!');
        loadEmployeeHomeView();

    } else if(authUser.roleName=='Fin mngr'){
        console.log('user is fin man!');
        loadFinanceManagerHomeView();

    } else {
        console.log('user is not allowed!');

    }


}
//#endregion

//#region load-employee-views

function loadEmployeeHomeView(){

    console.log('in loadEmployeeHomeView()');

    if(!isUserLoggedIn()){
        return;
    }

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'employeeHome.view');
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
            configureEmployeeHomeView();

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

function loadSubmitReimbursement() {

    console.log('in loadSubmitReimbursement()');

    if(!isUserLoggedIn()){
        return;
    }

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'submitReimbursement.view');
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
            configureSubmitReimbursementView();
        }
    }

}

function loadUpdateReimbursements() {

    console.log('in loadUpdateReimbursements()');

    if(!isUserLoggedIn()){
        return;
    }

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'updateReimbursements.view');
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
            configureUpdateReimbursementsView();
        }
    }

}

//#endregion

//#region load-admin-views

function loadAdminHomeView(){

    console.log('in loadAdminHomeView()');

    if(!isUserLoggedIn()){
        return;
    }

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'adminHome.view');
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
            configureAdminHomeView();

        }

    }

}

function loadAddNewUser(){

    console.log('in loadAddNewUser()');

    if(!isUserLoggedIn()){
        return;
    }

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'addNewUsers.view');
    xhr.send();

    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
            configureAddNewUserView();
        }
    }

}

function loadViewUsers(){
    console.log('in loadViewUsers()');

    if(!isUserLoggedIn()){
        return;
    }

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'loadViewUsers.view');

    xhr.send();

    console.log('loadViewUsers outside onreadystatechange');

    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
            console.log('loadViewUsers inside onreadystatechange');
            configureViewUsersView();
        }
    }

}

//#endregion

//#region load-finance-manager-views

function loadFinanceManagerHomeView(){

    console.log('in loadFinanceManagerHomeView()');

    if(!isUserLoggedIn()){
        return;
    }

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'financeManagerHome.view');
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
            configureFinanceManagerHomeView();

        }

    }

}

function loadAllReimbursementsView(){

    console.log('in loadAllReimbursements()');

    if(!isUserLoggedIn()){
        return;
    }

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'allReimbursements.view');
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            APP_VIEW.innerHTML = xhr.responseText;
            configureAllReimbursementsView();

        }

    }

}

//#endregion



//#region configure-navbars

function configureLoggedOutNavbar(){
    document.getElementById('toLogin').addEventListener('click', loadLogin);
    document.getElementById('toRegister').addEventListener('click', loadRegister);
}

function configureLoggedInNavbar(){

    let authUser = JSON.parse(localStorage.getItem('authUser'));;

    if(authUser.roleName=='Admin'){
        console.log('user is admin!');
        document.getElementById('toHome').addEventListener('click', loadAdminHomeView);

    } else if(authUser.roleName=='Employee'){
        console.log('user is employee!');
        document.getElementById('toHome').addEventListener('click', loadEmployeeHomeView);

    } else if(authUser.roleName=='Fin mngr'){
        console.log('user is fin man!');
        document.getElementById('toHome').addEventListener('click', loadFinanceManagerHomeView);

    } else {
        console.log('user is not allowed!');

    }

    document.getElementById('toProfile').addEventListener('click', loadProfile);
    document.getElementById('toLogout').addEventListener('click', logout);

}
//#endregion

//#region configure-logged-out-views


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

//#endregion

//#region configure-logged-in-for-all-views

function configureProfileView() {

    console.log('in configureProfileView()');
    //document.getElementById('mainParagraphProfile').innerText = getUserInfo();

    
    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'userinfo.read');
    xhr.send();

    xhr.onreadystatechange = function() {

        if (xhr.readyState == 4 && xhr.status == 200) {


            let userInfoView =  JSON.parse(xhr.responseText);
            //console.log("JSON responce text" + JSON.parse(xhr.responseText));
            //console.log("userInfoView: " + userInfoView);
            //console.log("userInfoViewRole: " + userInfoView.role);
            //let userRole = JSON.parse(userInfoView.role);

            let table = document.getElementById("profile-table");
            //userInfoView.firstName
            let head = document.createElement("thead");
            let body = document.createElement("tbody");
            table.appendChild(head);
            head.innerHTML =  "<tr>" 
                           + "<th>ID</th>"
                           + "<th>Username</th>"
                           + "<th>First Name</th>"
                           + "<th>Last Name</th>"
                           + "<th>Email</th>"
                           + "<th>Role</th>";

            table.appendChild(body);

            let row = document.createElement("tr");
            row.innerHTML   = "<td>" + userInfoView.id + "</td>" 
                            + "<td>" + userInfoView.username + "</td>"
                            + "<td>" + userInfoView.firstName + "</td>"
                            + "<td>" + userInfoView.lastName + "</td>"
                            + "<td>" + userInfoView.email + "</td>"
                            + "<td>" + userInfoView.roleName + "</td>";
            body.appendChild(row);
            
            // for (let i = 0; i < userInfoView; i++){
            //     console.log("in loop");
            //     let row = document.createElement("tr");

            //     row.innerHTML = "<td>" + userInfoView[i].id + "</td>" 
            //                   + "<td>" + userInfoView[i].username + "</td>"
            //                   + "<td>" + userInfoView[i].firstName + "</td>"
            //                   + "<td>" + userInfoView[i].lastName + "</td>"
            //                   + "<td>" + auserInfoView[i].email + "</td>"
            //                   + "<td>" + userInfoView[i].role + "</td>";

            //     body.appendChild(row);
            // }


            document.getElementById('profile').appendChild(table);

        }

    }

}


//#endregion

//#region configure-employee-views


function configureEmployeeHomeView(){

    console.log('in configureEmployeeHomeView()');

    let authUser = JSON.parse(localStorage.getItem('authUser'));

    document.getElementById('loggedInEmployeeUsername').innerText = authUser.username;

    document.getElementById('viewMyReimbursements').addEventListener('click', loadMyReimbursements);

    document.getElementById('submitReimbursement').addEventListener('click', loadSubmitReimbursement);

}

function configureMyReimbursementsView() {

    console.log('in configureMyReimbursementsView()');

}

function configureSubmitReimbursementView() {

    console.log('in configureSubmitReimbursementView()')
}


function configureUpdateReimbursementsView() {

    console.log('in configureReimbursementView()');

}

    //let authUser = JSON.parse(localStorage.getItem('authUser'));
    //document.getElementById('loggedInUsername').innerText = authUser.username;

//#endregion

//#region configure-admin-views

function configureAdminHomeView() {

    console.log('in configureHomeView()');
    let authUser = JSON.parse(localStorage.getItem('authUser'));

    document.getElementById('loggedInAdminUsername').innerText = authUser.username;
    document.getElementById('add-new-user').addEventListener('click', loadAddNewUser);
    document.getElementById('view-users').addEventListener('click', loadViewUsers);


}
function configureAddNewUserView(){

    console.log('in configureAddNewUserView()');

}

function configureViewUsersView(){

    console.log('in configureViewUsersView()');

}


//#endregion

//#region configure-finance-manager-views

function configureFinanceManagerHomeView() {

    console.log('in configureHomeView()');
    let authUser = JSON.parse(localStorage.getItem('authUser'));

    document.getElementById('loggedInFinanceManagerUsername').innerText = authUser.username;

    document.getElementById('view-all-reimbursements').addEventListener('click', loadAllReimbursementsView);

}

function configureAllReimbursementsView() {

    console.log('in configureAllReimbursementsView()');

    //let authUser = JSON.parse(localStorage.getItem('authUser'));
    //document.getElementById('loggedInUsername').innerText = authUser.username;

}
//#endregion



//#region operations
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

    let xhr = new XMLHttpRequest();

    xhr.open('GET', 'userinfo.database');
    xhr.send();

    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {

            let userInfoView =  JSON.parse(xhr.responseText);
            console.log("userInfoView: " + userInfoView);
            return userInfoView;
        }

    }

    return 'empty';
}


function isUserLoggedIn(){
    if (!localStorage.getItem('authUser')) {
        console.log('No user logged in, navigating to login screen');
        loadLoggedOutFullHome()
        return false;
    }

    return true;
}

//#endregion

//#region form-validation

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

//#endregion