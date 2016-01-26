/* 모듈 만들기 방법2 */
module.exports = function(op) {
  return{
    plus : function(a, b) { return a + b;  },
    minus : function(a, b) { return a - b;  },
    multiple : function(a, b) { return a * b;  },
    divide : function(a, b) { return a / b;  }
  };
};