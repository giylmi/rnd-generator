<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Генератор битовой последовательности</title>

    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap-theme.min.css"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div class="container">
    <h1 class="page-header">
        Генератор случайной последовательности
    </h1>
    <div class="col-md-4">
        <form class="js-form">
            <div class="form-group">
                <label for="type">Формат вывода</label>
                <div id="type" class="form-inline">
                    <label class="radio-inline">
                        <input type="radio" name="type" value="base64"> base64
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="type" value="hex"> hex
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="type" value="bin"> binary
                    </label>
                </div>
            </div>
            <div class="form-group">
                <label for="num">Количество бит</label>
                <div id="num" class="form-inline">
                    <label>
                        <input class="form-control" type="number" name="num" value="128">
                    </label>
                </div>
            </div>
            <button type="button" class="js-form-btn btn btn-primary">Сгенерировать</button>
        </form>
    </div>
    <div class="col-md-8">
        <div class="js-output">

        </div>
    </div>
</div>

<script src="/jquery-3.2.0.min.js"></script>
<script src="/index.js"></script>

</body>
</html>

