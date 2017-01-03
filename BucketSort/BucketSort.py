
##
# Bucket sorting of the array. Implicit assumption that all
# elements are less than 100
##
def bucketSort(array):
  buckets = [[],[],[],[],[],[],[],[],[],[]]
  for element in array:
    bucketNumber = int(element / 10)
    buckets[bucketNumber].append(element)
  returnArray = []
  for bucket in buckets:
    bucket.sort()
    returnArray.extend(bucket)
  return returnArray


print(bucketSort([2,1,62,34,26,53,26,57,3]))
