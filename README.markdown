# Mill Scala Seed

A [Giter8](http://www.foundweekends.org/giter8/index.html) template for a sample
Scala bot using the [zmatrix](https://github.com/bot4s/zmatrix) library and
[Mill build tool](https://github.com/com-lihaoyi/mill)!

## Prerequisites

Install Giter8 with [Coursier](https://get-coursier.io/).

```sh
cs install giter8
```

## Create new project

To create a new project just run:

```sh
g8 ex0ns/mill-zmatrix-seed.g8
```

or use the `New Scala project` command in [Metals](https://scalameta.org/metals)

## Configure the new project

The bot name must be configured inside `bot.conf`.
A password can be provided using the `MATRIX_BOT_PASSWORD` environment variable. Once
you have an access token, the `MATRIX_BOT_ACCESS` environment variable should be set to its
value.

You should not be able to run your bot using mill:

```
mill -i __.run
```

Note that the `-i` is important to provide the environment variables to our bot.

