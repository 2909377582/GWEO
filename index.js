
document.addEventListener("DOMContentLoaded", () => {
    const dropdown = document.querySelector(".box-dropdown-icon");
    const option_list = document.querySelector(".option-list");
    const options = document.querySelectorAll(".option");
    
    /* 显示或隐藏选项列表 */
    dropdown.addEventListener("click",() => {
        option_list.classList.toggle("active");
        dropdown.querySelector(".bi-chevron-down").classList.toggle("bi-chevron-up");
    });

    /*选项列表 */
    options.forEach((option) => {
        option.addEventListener("click", () =>{
            options.forEach((option) => {option.classList.remove('selected')});
            dropdown.querySelector("span").innerHTML = option.innerHTML;
            option.classList.add("seleced");
            option_list.classList.toggle("active");
            dropdown.querySelector(".bi-chevron-down").classList.toggle("bi-chevron-up");
        });
    })
    
  });
  