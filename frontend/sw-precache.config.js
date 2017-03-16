module.exports = {
  navigateFallback: '/index.html',
  stripPrefix: 'dist',
  root: 'dist/',
  staticFileGlobs: [
    'dist/index.html',
    'dist/*.js',
    'dist/*.css',
    'dist/*.woff2',
    'dist/assets/imgs/*.png',
    'dist/assets/imgs/*.jpg',
    'dist/assets/imgs/*.jpeg',
    'dist/assets/imgs/*.svg',
    'dist/assets/*.css',
    'dist/assets/*.json',
    'dist/assets/imgs/**/*.png',
    'dist/assets/imgs/**/*.jpg'
  ]
};