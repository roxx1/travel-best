gulp = require 'gulp'
gutil = require 'gulp-util'
coffee = require 'gulp-coffee'
stylus = require 'gulp-stylus'
plumber = require 'gulp-plumber'

gulp.task 'coffee', -> 
	gulp.src 'scripts/*.coffee'
		.pipe plumber()
		.pipe coffee({bare: true})
		.on('error', gutil.log)
		.pipe gulp.dest('../static/js/')

gulp.task 'styl', ->
	gulp.src 'styles/*.styl'
		.pipe plumber()
		.pipe stylus({compress: false, 'include css': true})
		.pipe gulp.dest('../static/css/')

gulp.task 'watch',  ->
	gulp.watch 'styles/*.styl', ['styl']
	gulp.watch 'scripts/*.coffee', ['coffee']

gulp.task 'default', ['styl', 'coffee', 'watch'], -> 