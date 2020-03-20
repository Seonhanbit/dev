from flask import Flask, request
import json
from flask_cors import CORS
import example_downloadimage as ed

app = Flask(__name__)
CORS(app)

@app.route('/')
def get_img():
    ed.get_finger()
    return 'Hello World'


if __name__ == '__main__':
    app.run(host='0.0.0.0')