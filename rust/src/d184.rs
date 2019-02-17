use std::vec::Vec;

/// Given n numbers, find the greatest common denominator between them.
/// For example, given the numbers [42, 56, 14], return 14.
/// The given vector can't be empty
fn greatest_common_denominator(vec: &Vec<i64>) -> i64 {
    if vec.is_empty() {
        panic!("The vector can't be empty")
    }

    let factors: Vec<Vec<i64>> = vec.iter().map(|x|
        extract_factors(*x)
    ).collect();

    println!("factors {:?}", factors);

    let mut distinct_factors: Vec<&i64> = factors.iter().flatten().collect();
    distinct_factors.sort();
    distinct_factors.dedup_by(|a, b| a == b);

    println!("distinct_factors {:?}", distinct_factors);

    let common: Vec<i64> = distinct_factors.iter().map(|single_factor| {
        let count = factors.iter().map(|factors_of_number|
            factors_of_number.iter().filter(|f|
                f == single_factor
            ).count()
        ).min().unwrap();
        let mut fs = Vec::with_capacity(count);
        for __ in 0..count {
            fs.push(**single_factor)
        }
        fs
    }).flatten().collect();

    println!("common {:?}", common);

    common.iter().product()
}

fn extract_factors(n: i64) -> Vec<i64> {
    if n <= 0 {
        panic!("Can't extract the factors of {}", n)
    }
    let mut index = 2;
    let reference = n.clone();
    let mut current = n.clone();
    let mut factors = Vec::new();
    loop {
        while current % index == 0 {
            factors.push(index);
            current = current / index;
        }
        index += 1;
        if index > reference {
            break;
        }
    }
    factors
}

#[cfg(test)]
mod tests {
    // Note this useful idiom: importing names from outer (for mod tests) scope.
    use super::*;

    #[test]
    fn test_extract_factors_of_2() {
        assert_eq!(
            extract_factors(2),
            [2].to_vec()
        );
    }

    #[test]
    fn test_extract_factors_of_10() {
        assert_eq!(
            extract_factors(10),
            [2, 5].to_vec()
        );
    }

    #[test]
    fn test_extract_factors_of_81() {
        assert_eq!(
            extract_factors(81),
            [3, 3, 3, 3].to_vec()
        );
    }

    #[test]
    fn test_extract_factors_of_360() {
        assert_eq!(
            extract_factors(360),
            [2, 2, 2, 3, 3, 5].to_vec()
        );
    }

    #[test]
    #[should_panic(expected = "Can't extract the factors of 0")]
    fn test_extract_factors_of_0() {
        extract_factors(0);
    }

    #[test]
    fn test_a() {
        assert_eq!(
            greatest_common_denominator(&[42, 56, 14].to_vec()),
            14
        );
    }

    #[test]
    fn test_b() {
        assert_eq!(
            greatest_common_denominator(&[7, 11].to_vec()),
            1
        );
    }

    #[test]
    fn test_c() {
        assert_eq!(
            greatest_common_denominator(&[400, 360, 1440].to_vec()),
            40
        );
    }

    #[test]
    #[should_panic(expected = "The vector can't be empty")]
    fn test_z0() {
        greatest_common_denominator(&[].to_vec());
    }
}