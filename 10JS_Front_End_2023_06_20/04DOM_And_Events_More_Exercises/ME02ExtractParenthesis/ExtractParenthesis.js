function extract(content) {
    let text = document.querySelector(`#${content}`).textContent;

    let re = /\(([^\)(]*)\)/gm;

    return [...text.matchAll(re)].map(w => w[1]).join('; ');

}