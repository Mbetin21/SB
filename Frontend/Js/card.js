let currentCardIndex = 0;
const cards = document.querySelectorAll('.article');
const nopeButton = document.querySelector('.nope');
const likeButton = document.querySelector('.like');

function removeCard(direction) {
    if (currentCardIndex >= cards.length) return;
            
    let card = cards[currentCardIndex];
    card.style.transition = 'transform 0.5s ease, opacity 0.5s ease';
    card.style.transform = `translateX(${direction === 'right' ? 500 : -500}px) rotate(${direction === 'right' ? 20 : -20}deg)`;
    card.style.opacity = '0';
            
    setTimeout(() => {
        card.style.display = 'none';
        currentCardIndex++;
        if (currentCardIndex < cards.length) {
            cards[currentCardIndex].style.display = 'block';
        }
    }, 500);
}

nopeButton.addEventListener('click', () => removeCard('left'));
likeButton.addEventListener('click', () => removeCard('right'));

fetch("http://localhost:8000/users")
    .then(response => response.json())
    .then(data => {
        data.forEach(user => {
            let card = document.createElement("div");
            card.innerHTML = `
                <h3>${user.nombre}</h3>
                <p>Habla ${user.idioma_habla}, aprendiendo ${user.idioma_aprender}.</p>
                <p>Intereses: ${user.intereses.join(", ")}</p>
            `;
            document.body.appendChild(card);
        });
    });
