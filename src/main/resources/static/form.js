function submit_file() {
    let file = document.getElementById("file");
    const url = 'movement';

    let formData = new FormData();
    formData.append('file', file.files[0]);

    fetch(url, {
        body: formData,
        method: "post"
    })
        .then((response) => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('Something went wrong');
        })
        .then(result => {
            location.href = '/';
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

 document.getElementById("btn-submit").addEventListener("click", submit_file);
