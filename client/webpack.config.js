'use strict';

var webpack = require('webpack');
var path = require('path');
var express = require('express');

module.exports = {
    entry: './server.js',
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'bu,i2ld.js'
    },
    node: {
        fs: "empty",
        net: 'empty'
    },
    watch: true,

    watchOptions: {
        aggregateTimeout: 100,
    },

    devtool: "source-map"
};

