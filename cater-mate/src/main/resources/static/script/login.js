let element = document.getElementById("form");
let ele = document.getElementById("feedback");
if (element.addEventListener) {
  element.addEventListener("submit", main_validator, true);
} else if (ele.attachEvent) {
  element.attachEvent("onsubmit", main_validator);
}

function main_validator(e) {
  console.log(e);
  e.preventDefault();
  ele.innerHTML = "";
  if (check_username(e.target[0].value)) {
    element.submit();
  }
}

function check_username(username) {
  let re = new RegExp(/^[a-zA-Z]+[a-zA-Z0-9]*$/);
  let message = "";
  let someWrong = false;
  console.log(re.test(username));
  if (!re.test(username)) {
    message +=
      "Username must start with a letter [a-z], [A-Z] and can only contain [a-z], [A-Z], or [0-9]. ";
    someWrong = true;
  }
  if (username.length < 4 || username.length > 20) {
    message += "Username must be 4-20 characters.";
    someWrong = true;
  }
  if (someWrong) {
    let para = document.createElement("P");
    para.classList.add("danger");
    let t = document.createTextNode(message);
    para.appendChild(t);
    ele.appendChild(para);
    return false;
  }
  return true;
}
