struct Solution {
}

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut ret: Vec<i32> = vec![];
        let len = nums.len();
        let mut i = 0;
        while i < len {
            let mut j = i+1;
            while j < len {
                if nums[i] + nums[j] == target {
                    ret.push(i as i32);
                    ret.push(j as i32);
                    return ret;
                }

                j = j+1;
            }
            i = i+1;
        }
        return ret;
    }
}

fn main() {
    println!("{:?}", Solution::two_sum(vec![1,2], 3)); // [0,1]
    println!("{:?}", Solution::two_sum(vec![3,2,4], 6)); // [1,2]
}