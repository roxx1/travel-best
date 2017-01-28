/**
 * Copyright 2016 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

// DO NOT EDIT THIS GENERATED OUTPUT DIRECTLY!
// This file should be overwritten as part of your build process.
// If you need to extend the behavior of the generated service worker, the best approach is to write
// additional code and include it using the importScripts option:
//   https://github.com/GoogleChrome/sw-precache#importscripts-arraystring
//
// Alternatively, it's possible to make changes to the underlying template file and then use that as the
// new base for generating output, via the templateFilePath option:
//   https://github.com/GoogleChrome/sw-precache#templatefilepath-string
//
// If you go that route, make sure that whenever you update your sw-precache dependency, you reconcile any
// changes made to this original template file with your modified copy.

// This generated service worker JavaScript will precache your site's resources.
// The code needs to be saved in a .js file at the top-level of your site, and registered
// from your pages in order to be used. See
// https://github.com/googlechrome/sw-precache/blob/master/demo/app/js/service-worker-registration.js
// for an example of how you can register this script and handle various service worker events.

/* eslint-env worker, serviceworker */
/* eslint-disable indent, no-unused-vars, no-multiple-empty-lines, max-nested-callbacks, space-before-function-paren, quotes, comma-spacing */
'use strict';

var precacheConfig = [["app/app.component.css","ff2d25f2567ce0988bb947b561e0e0ba"],["app/app.component.html","e82186fb6aa8adec45f1205578dde634"],["app/app.component.spec.ts","bd984517f3dfa28b046c5aee15d26fe5"],["app/app.component.ts","ac1e4e8b66748b4e9421a762fe472aea"],["app/app.module.ts","c319454239d3f30cc1f9d0e620b953c6"],["app/footer/footer.component.css","ac44721f659f03d0fc2493410b60a5df"],["app/footer/footer.component.html","4bd2f15fc0991e8eac41ddc2fea224ea"],["app/footer/footer.component.spec.ts","214557c48cce1c65410f4d689d91353d"],["app/footer/footer.component.ts","1eb8c1f421545b99a234bc8ed489fd43"],["app/header/header.component.css","455781904682d3acf5ebe92151ad1984"],["app/header/header.component.html","02f0506ac3d55f146e6fe31081075bd5"],["app/header/header.component.spec.ts","c83a5297b7b34ef1b60d759b62d8644c"],["app/header/header.component.ts","6d61cd0e6c88344c4b7477302cfb5468"],["app/login/login.component.css","6983dc50d7640b615ea848dfedd9e1fb"],["app/login/login.component.html","535c7fbe77b604e50ba906d1c3d0ceaa"],["app/login/login.component.spec.ts","65383c93eb08d87a4dc02fb7ff8ea531"],["app/login/login.component.ts","c4dd7e8940cc14635dda242694c40fa2"],["app/models/order.model.ts","f4da9f7986b39c50a1a5dbec5994199b"],["app/models/route.model.ts","e321e9ab0baf7fa81612b70ee1cbfaff"],["app/models/trip.model.ts","8504a5f5b1f80a34df4daf78099fbb79"],["app/nav/nav.component.css","8cfd3cec3fdfd9ceb7ad71abd3c7f57c"],["app/nav/nav.component.html","5deba47473e03f75659ecbf1ce067dcc"],["app/nav/nav.component.spec.ts","92f82a28a73914a9cc08a774a1510341"],["app/nav/nav.component.ts","fe7086fb0e3a374446bdc514a9b95fe0"],["app/orders/orders.component.css","2189213cb563178fe620705e33a7befd"],["app/orders/orders.component.html","171b7f39f5cb79e4ef767efa88e26c3b"],["app/orders/orders.component.spec.ts","e6eea545b56c53ea55f7b9927d3a554c"],["app/orders/orders.component.ts","1c42db0064c0bed9192290d219f5cb12"],["app/signup/signup.component.css","4dda3ffb63fc5d71be9991f8a1ab9011"],["app/signup/signup.component.html","313c9be0f647f44f985798c89f554c8f"],["app/signup/signup.component.spec.ts","a83cbb50098572cba47616f94f7e3a7a"],["app/signup/signup.component.ts","2d100eccd6107ccc28c8bc1a1955ad23"],["app/trips/trip-details/trip-details.component.css","b508db424e61aba45e0234371baefbae"],["app/trips/trip-details/trip-details.component.html","205a389a8ff6dc2f2b776881ee6094e4"],["app/trips/trip-details/trip-details.component.spec.ts","03a4ae401d55c67b757a62e9175ad1c9"],["app/trips/trip-details/trip-details.component.ts","37666bff653b1bd80378d22335e7f1b9"],["app/trips/trips.component.css","2285af0cc13e2da972dad767f350e6e8"],["app/trips/trips.component.html","1ac7b0ce54e85dc3de0eb7351f86b8c0"],["app/trips/trips.component.spec.ts","f7d32468a635433a0abc42bbcd138b50"],["app/trips/trips.component.ts","b62bb1ffa75eeb1a276edffbe3e1061e"],["assets/imgs/crossword.png","b5c5ab66d8331513696fe3ec992187a0"],["assets/imgs/green_cup.png","96afd6735a6dc54741e6a4d1c4235590"],["assets/imgs/logo/travelbest-optimized.svg","79311c040a1104b54ea4571d55fb6857"],["assets/imgs/logo/travelbest.png","bf5a3353443e4357ef1bf1f951d96cb9"],["assets/imgs/logo/travelbest.svg","6824b6aa7398220652544b5e76b09fe6"],["assets/imgs/payment-systems/bank.jpg","8d82129a9ba4057076a369451f9ddb06"],["assets/imgs/payment-systems/cash.jpg","0bd2fc1189b8932d37f904cbc722cd5d"],["assets/imgs/payment-systems/payoneer.png","dfc5203f376be4685d2421bb17f67e68"],["assets/imgs/payment-systems/paypal.png","e7cbcaa14ba5db0160c268042e02db3c"],["assets/imgs/slider/nature2.jpg","89397c3e8bcce19b14b79ac7bffe2d48"],["assets/imgs/slider/nature4.jpg","faf23be0140ca1d0e8fb05fb5e61290a"],["assets/imgs/slider/nature5.jpg","91a61d95b4fe4f22eac416446244c616"],["environments/environment.prod.ts","6de221395114600b523995704b7d1caa"],["environments/environment.ts","a8393b7aa331fe98c2da499ea0c09b28"],["favicon.png","240faf4e5242abe2d6a25127538290ff"],["index.html","30a71728b0e416eac0af213bb05ace89"],["main.ts","fcc2b1095abe5d70d6db8ef33da37b0f"],["polyfills.ts","8f7896ac43558382fa0383d2d197f1c0"],["styles.css","ac89bfdd6de82636b7680c8b96584c96"],["test.ts","f9ce8268b8d119d28dd1cf94251fe6a2"],["tsconfig.json","af203de8126b677b5d883393151cfe3c"]];
var cacheName = 'sw-precache-v2-sw-precache-' + (self.registration ? self.registration.scope : '');


var ignoreUrlParametersMatching = [/^utm_/];



var addDirectoryIndex = function (originalUrl, index) {
    var url = new URL(originalUrl);
    if (url.pathname.slice(-1) === '/') {
      url.pathname += index;
    }
    return url.toString();
  };

var createCacheKey = function (originalUrl, paramName, paramValue,
                           dontCacheBustUrlsMatching) {
    // Create a new URL object to avoid modifying originalUrl.
    var url = new URL(originalUrl);

    // If dontCacheBustUrlsMatching is not set, or if we don't have a match,
    // then add in the extra cache-busting URL parameter.
    if (!dontCacheBustUrlsMatching ||
        !(url.toString().match(dontCacheBustUrlsMatching))) {
      url.search += (url.search ? '&' : '') +
        encodeURIComponent(paramName) + '=' + encodeURIComponent(paramValue);
    }

    return url.toString();
  };

var isPathWhitelisted = function (whitelist, absoluteUrlString) {
    // If the whitelist is empty, then consider all URLs to be whitelisted.
    if (whitelist.length === 0) {
      return true;
    }

    // Otherwise compare each path regex to the path of the URL passed in.
    var path = (new URL(absoluteUrlString)).pathname;
    return whitelist.some(function(whitelistedPathRegex) {
      return path.match(whitelistedPathRegex);
    });
  };

var stripIgnoredUrlParameters = function (originalUrl,
    ignoreUrlParametersMatching) {
    var url = new URL(originalUrl);

    url.search = url.search.slice(1) // Exclude initial '?'
      .split('&') // Split into an array of 'key=value' strings
      .map(function(kv) {
        return kv.split('='); // Split each 'key=value' string into a [key, value] array
      })
      .filter(function(kv) {
        return ignoreUrlParametersMatching.every(function(ignoredRegex) {
          return !ignoredRegex.test(kv[0]); // Return true iff the key doesn't match any of the regexes.
        });
      })
      .map(function(kv) {
        return kv.join('='); // Join each [key, value] array into a 'key=value' string
      })
      .join('&'); // Join the array of 'key=value' strings into a string with '&' in between each

    return url.toString();
  };


var hashParamName = '_sw-precache';
var urlsToCacheKeys = new Map(
  precacheConfig.map(function(item) {
    var relativeUrl = item[0];
    var hash = item[1];
    var absoluteUrl = new URL(relativeUrl, self.location);
    var cacheKey = createCacheKey(absoluteUrl, hashParamName, hash, false);
    return [absoluteUrl.toString(), cacheKey];
  })
);

function setOfCachedUrls(cache) {
  return cache.keys().then(function(requests) {
    return requests.map(function(request) {
      return request.url;
    });
  }).then(function(urls) {
    return new Set(urls);
  });
}

self.addEventListener('install', function(event) {
  event.waitUntil(
    caches.open(cacheName).then(function(cache) {
      return setOfCachedUrls(cache).then(function(cachedUrls) {
        return Promise.all(
          Array.from(urlsToCacheKeys.values()).map(function(cacheKey) {
            // If we don't have a key matching url in the cache already, add it.
            if (!cachedUrls.has(cacheKey)) {
              return cache.add(new Request(cacheKey, {
                credentials: 'same-origin',
                redirect: 'follow'
              }));
            }
          })
        );
      });
    }).then(function() {
      
      // Force the SW to transition from installing -> active state
      return self.skipWaiting();
      
    })
  );
});

self.addEventListener('activate', function(event) {
  var setOfExpectedUrls = new Set(urlsToCacheKeys.values());

  event.waitUntil(
    caches.open(cacheName).then(function(cache) {
      return cache.keys().then(function(existingRequests) {
        return Promise.all(
          existingRequests.map(function(existingRequest) {
            if (!setOfExpectedUrls.has(existingRequest.url)) {
              return cache.delete(existingRequest);
            }
          })
        );
      });
    }).then(function() {
      
      return self.clients.claim();
      
    })
  );
});


self.addEventListener('fetch', function(event) {
  if (event.request.method === 'GET') {
    // Should we call event.respondWith() inside this fetch event handler?
    // This needs to be determined synchronously, which will give other fetch
    // handlers a chance to handle the request if need be.
    var shouldRespond;

    // First, remove all the ignored parameter and see if we have that URL
    // in our cache. If so, great! shouldRespond will be true.
    var url = stripIgnoredUrlParameters(event.request.url, ignoreUrlParametersMatching);
    shouldRespond = urlsToCacheKeys.has(url);

    // If shouldRespond is false, check again, this time with 'index.html'
    // (or whatever the directoryIndex option is set to) at the end.
    var directoryIndex = 'index.html';
    if (!shouldRespond && directoryIndex) {
      url = addDirectoryIndex(url, directoryIndex);
      shouldRespond = urlsToCacheKeys.has(url);
    }

    // If shouldRespond is still false, check to see if this is a navigation
    // request, and if so, whether the URL matches navigateFallbackWhitelist.
    var navigateFallback = '';
    if (!shouldRespond &&
        navigateFallback &&
        (event.request.mode === 'navigate') &&
        isPathWhitelisted([], event.request.url)) {
      url = new URL(navigateFallback, self.location).toString();
      shouldRespond = urlsToCacheKeys.has(url);
    }

    // If shouldRespond was set to true at any point, then call
    // event.respondWith(), using the appropriate cache key.
    if (shouldRespond) {
      event.respondWith(
        caches.open(cacheName).then(function(cache) {
          return cache.match(urlsToCacheKeys.get(url)).then(function(response) {
            if (response) {
              return response;
            }
            throw Error('The cached response that was expected is missing.');
          });
        }).catch(function(e) {
          // Fall back to just fetch()ing the request if some unexpected error
          // prevented the cached response from being valid.
          console.warn('Couldn\'t serve response for "%s" from cache: %O', event.request.url, e);
          return fetch(event.request);
        })
      );
    }
  }
});







