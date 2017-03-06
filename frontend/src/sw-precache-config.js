module.exports = {
  navigateFallback: '/',
  runtimeCaching: [{
    urlPattern: /.*/,
    handler: 'networkFirst'
  }]
};