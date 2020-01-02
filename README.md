docker build -t vertxsample .

docker run --env-file envhello.list -p 9595:9595 vertxsample