/*var 变量可变 const变量不可变，除了数组或对象 */
document.addEventListener("DOMContentLoaded", () => {
    const dropdown = document.querySelector(".box-dropdown-icon");
    const option_list = document.querySelector(".option-list");
    const options = document.querySelectorAll(".option");

    
    

    /* 显示或隐藏选项列表 */
    dropdown.addEventListener("click",() => {
        option_list.classList.toggle("active");
        dropdown.querySelector(".bi-chevron-down").classList.toggle("bi-chevron-up");
    });
    /*上载功能 */

    /*选项列表呈现 */
    options.forEach((option) => {
        option.addEventListener("click", () =>{
            options.forEach((option) => {option.classList.remove('selected')});
            /*找到 dropdown 中的第一个 span 元素，将其 innerHTML 设置为选项的 innerHTML。*/
            dropdown.querySelector("span").innerHTML = option.innerHTML;
            /*
            add :添加类名到元素的class属性里
            toggle:切换元素的“active”类名，如果有，则去除，如果没有，则添加，类似开关
             */
            option.classList.add("seleced");
            option_list.classList.toggle("active");
            dropdown.querySelector(".bi-chevron-down").classList.toggle("bi-chevron-up");
        });
    }) ;

  });

  
  


  