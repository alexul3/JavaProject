let form = document.getElementById("form");
let info = document.getElementById("res");


form.onsubmit = async (e) => {
  e.preventDefault();

  if(form.x.value === "") return;
  if(form.y.value === "") return;

  let index = form.selected.selectedIndex;

  let op = form.selected.options[index].textContent;
  let res = "";

  switch(op) {
    case "+":
      res = await fetch(`http://localhost:8080/sum?x=${form.x.value}&y=${form.y.value}`)
      res = await res.text();
      break;
    case "-":
      res = await fetch(`http://localhost:8080/diff?x=${form.x.value}&y=${form.y.value}`)
      res = await res.text();
      break;

    case "*":
        res = await fetch(`http://localhost:8080/multiply?x=${form.x.value}&y=${form.y.value}`)
        res = await res.text();
        break;
        
    case "**":
      res = await fetch(`http://localhost:8080/degree?x=${form.x.value}&y=${form.y.value}`)
      res = await res.text();
      break;

      case "/":
        if(form.y.value == 0) return;
        res = await fetch(`http://localhost:8080/divide?x=${form.x.value}&y=${form.y.value}`)
        res = await res.text();
        break;
  }

  info.textContent = res;
}