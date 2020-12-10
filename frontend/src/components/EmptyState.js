import React from 'react';

export default function EmptyState(props) {
    return(
        <>
            <h3 style={styles.heading}>My Favorites</h3>
            <div className="text-center">
                <h2>Belum ada item yang dipilih</h2>
                <h6>Klik salah satu item di List Movies</h6>
            </div>
        </>
    )


}

const styles = {
    heading: {
        fontFamily: "courier new",
    },
};