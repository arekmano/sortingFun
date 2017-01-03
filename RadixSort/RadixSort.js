
function radixSort(array){
  buckets = bucketsOf1(array);
  buckets = bucketsOf10(buckets);
  buckets = bucketsOf100(buckets);
  returnArray = [];
  buckets.forEach(function(bucket){
    returnArray = returnArray.concat(bucket);
  });
  return returnArray;
}

function bucketsOf1(array){
  buckets = [[],[],[],[],[],[],[],[],[],[]];
  array.forEach(function(element){
    buckets[element % 10].push(element);
  });
  return buckets;
}

function bucketsOf10(buckets){
  returnBuckets = [[],[],[],[],[],[],[],[],[],[]];
  buckets.forEach(function(bucket){
    bucket.forEach(function(element){
      returnBuckets[parseInt(element % 100 / 10)].push(element);
    });
  });
  return returnBuckets;
}

function bucketsOf100(buckets){
  returnBuckets = [[],[],[],[],[],[],[],[],[],[]];
  buckets.forEach(function(bucket){
    bucket.forEach(function(element){
      returnBuckets[parseInt(element / 100)].push(element);
    });
  });
  return returnBuckets;
}

console.log(radixSort([10,23,53,6,34,65,2,86,21,53]));