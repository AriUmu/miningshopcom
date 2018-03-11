'use strict';

var webpack = require('webpack');
var path = require('path');
var express = require('express');

module.exports = {
    entry: './server.js',
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'build.js'
    },
    node: {
        fs: "empty",
        net: 'empty'
    },

};

