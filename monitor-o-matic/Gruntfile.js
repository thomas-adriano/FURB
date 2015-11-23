module.exports = function(grunt) {

  // Project configuration.
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    browserify: {
      dist: {
        files: {
          'bundle/main.js': ['fragments/**/*.js']
        }
      }, options: {
        watch: true,
        keepAlive: true,
        alias: {
          'monitor-o-matic': './fragments/app.js',
          'chart-factory': './libs/chartFactory.js'
        }
      }
    }
  });

  grunt.loadNpmTasks('grunt-browserify');

  // Default task(s).
  grunt.registerTask('default', ['browserify']);

};
