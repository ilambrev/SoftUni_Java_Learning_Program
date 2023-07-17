function attachGradientEvents() {
    let gradientBox = document.querySelector('#gradient-box');

    gradientBox.addEventListener('mousemove', (e) => {
        let x = Math.floor((e.offsetX) / 3);
        document.querySelector('#result').textContent = `${x}%`;
    });
}