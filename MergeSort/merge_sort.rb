def merge_sort(array)
  if array.size <= 1
    return array
  end
  half_size = array.size/2
  array1 = array[0..half_size-1]
  array2 = array[half_size..-1]
  array1 = merge_sort(array1)
  array2 = merge_sort(array2)
  merge(array1, array2)
end

def merge(array1, array2)
  return_array = []
  while array1.size > 0 || array2.size > 0
    if array1.empty?
      return_array << array2.shift
    elsif array2.empty?
      return_array << array1.shift
    elsif array1.first >= array2.first
      return_array << array2.shift
    else
      return_array << array1.shift
    end
  end
  return_array
end
